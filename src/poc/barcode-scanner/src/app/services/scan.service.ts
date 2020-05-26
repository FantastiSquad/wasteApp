import { Injectable } from '@angular/core';
import { BarcodeScanner, BarcodeScannerOptions } from '@ionic-native/barcode-scanner/ngx';


@Injectable({
  providedIn: 'root'
})
export class ScanService {

  barcodeScannerOptions: BarcodeScannerOptions;
  scannedData: string;
  constructor(private barcodeScanner: BarcodeScanner) {
    this.barcodeScannerOptions = {
      showTorchButton: true,
      showFlipCameraButton: true
    };
   }

  public getBareCode() {
   const bareCode = this.barcodeScanner.scan().then(barcodeData => {
     alert('Barcode data ' + JSON.stringify(barcodeData));
     this.scannedData = JSON.stringify(barcodeData);
     console.log('Barcode data', barcodeData);
     }).catch(err => {
         console.log('Error', err);
     });
   console.log('Scanned data : ' + this.scannedData);
  }
}
