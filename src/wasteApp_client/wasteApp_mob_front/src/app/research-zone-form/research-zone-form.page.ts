import { Component, OnInit, Input } from '@angular/core';
import { ModalController, NavParams } from '@ionic/angular';

@Component({
  selector: 'app-research-zone-form',
  templateUrl: './research-zone-form.page.html',
  styleUrls: ['./research-zone-form.page.scss'],
})
export class ResearchZoneFormPage implements OnInit {
  
  @Input() public localities: string[];
  public locality: string = "";

  constructor(navParams: NavParams, public modalCtrl: ModalController) {
    console.log("ResearchZoneFormPage.constructor()");
    this.localities = navParams.get('localities');
    console.log("> localities: "); console.log(this.localities);
    this.locality=this.localities.join(" ");
  }

  ngOnInit() {
  }

  localityConfirm() {
    this.locality = this.locality.trim();
    console.log("ResearchZoneFormPage.localityConfirm("+this.locality+")");

    // using the injected ModalController this page
    // can "dismiss" itself and optionally pass back data
    // in case of backdrop dismiss (echap or close) -> returned data is : {"role":"backdrop"}
    // this.modalCtrl.dismiss(this.locality); -> returned data is : {"data": this.locality}
    this.modalCtrl.dismiss({ locality: this.locality });
  }
  
  closeModal() { this.modalCtrl.dismiss();}
}
