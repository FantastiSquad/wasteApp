import { Component, OnInit, Input } from '@angular/core';
import { NavParams, PopoverController } from '@ionic/angular';

@Component({
  selector: 'app-research-zone-form-popover',
  templateUrl: './research-zone-form-popover.component.html',
  styleUrls: ['./research-zone-form-popover.component.scss'],
})
export class ResearchZoneFormPopoverComponent implements OnInit {

  @Input() public localities: string[];
  public locality: string = "";
  
  constructor(navParams: NavParams, public popoverController: PopoverController) {
    console.log("ResearchZoneFormPopoverComponent.constructor()");
    this.localities = navParams.get('localities');
    console.log("> localities: "); console.log(this.localities);
    this.locality=this.localities.join(" ");
    console.log("> locality: "+ this.locality);
  }

  ngOnInit() {
  }

  localityConfirm() {
    this.locality = this.locality.trim();
    console.log("ResearchZoneFormPopoverComponent.localityConfirm("+this.locality+")");

    // using the injected ModalController this page
    // can "dismiss" itself and optionally pass back data
    // in case of backdrop dismiss (echap or close) -> returned data is : {"role":"backdrop"}
    // this.modalCtrl.dismiss(this.locality); -> returned data is : {"data": this.locality}
    this.popoverController.dismiss({ locality: this.locality });
  }
  
  closePopover() { this.popoverController.dismiss();}
}
