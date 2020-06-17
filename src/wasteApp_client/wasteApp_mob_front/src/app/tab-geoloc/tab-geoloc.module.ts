import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { TabGeolocPageRoutingModule } from './tab-geoloc-routing.module';

import { TabGeolocPage } from './tab-geoloc.page';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    TabGeolocPageRoutingModule,
    RouterModule.forChild([{ path: '', component: TabGeolocPage }]),
  ],
  declarations: [TabGeolocPage]
})
export class TabGeolocPageModule {}
