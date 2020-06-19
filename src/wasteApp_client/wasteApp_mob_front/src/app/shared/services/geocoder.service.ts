import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GeocoderService {

  // https://api.openrouteservice.org/geocode/reverse?api_key=your-api-key&point.lon=2.294471&point.lat=48.858268
  private base_URL: string = "https://api.openrouteservice.org";
  private api_key: string ="5b3ce3597851110001cf624858a603515f754806bc51c989d6a2d330";
  private endpoint: string = "/geocode/reverse";

  constructor(private http : HttpClient) { }

  public getAddress(latitude: string, longitude: string): Promise<any>{
    return this.request({ 
      method: 'GET', 
      data: {}, 
      queryParams: { 
        api_key: this.api_key, 
        'point.lat': latitude, 
        'point.lon': longitude, 
        size: 1, // layers: 'locality' 
      }}).then(res => res.features[0].properties);
  }

  public async request({ method = 'GET', data = {}, queryParams = {}}:
    { method?:string ;data?: object; queryParams?: any;}): Promise<any>{
    const methodWanted = method.toLowerCase();
    const url = this.base_URL + this.endpoint;
    const requestOptions = {
      params: queryParams
    };
    let req: Observable<any> = null;
    if (methodWanted === 'get') {
      req = this.http.get(url, {...requestOptions, observe: 'response'});
    } else if (methodWanted === 'post') {
      req = this.http.post(url, data, {...requestOptions, observe: 'response'});
    } else if (methodWanted === 'put') {
      req = this.http.put(url, data, {...requestOptions, observe: 'response'});
    } else if (methodWanted === 'delete') {
      req = this.http.delete(url, {...requestOptions, observe: 'response'});
    }

    if (!req) {
      throw new Error(`error calling ${url} with method ${methodWanted}`);
    }

    // Conversion du résultat en promesse
    const res = await req.toPromise();
    return res.body;
  }
}
