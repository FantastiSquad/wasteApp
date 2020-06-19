import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { IonSlides, NavController} from '@ionic/angular';
import { Storage } from '@ionic/storage';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.page.html',
  styleUrls: ['./welcome.page.scss'],
})
export class WelcomePage implements OnInit {

  @ViewChild(IonSlides)
  slides: IonSlides;
  constructor(private storage: Storage, private router: Router, private nav: NavController) { }

  ngOnInit() {
  }

  next(){
   this.slides.slideNext();
  }

  async finished(){
    await this.storage.set('tutorialComplete', 'true');
    this.nav.navigateRoot('/tabs/tab-home');
  }
}
