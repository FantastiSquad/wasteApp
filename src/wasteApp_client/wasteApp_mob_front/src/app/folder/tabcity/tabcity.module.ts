import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { TabcityPageRoutingModule } from './tabcity-routing.module';

import { TabcityPage } from './tabcity.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    TabcityPageRoutingModule
  ],
  declarations: [TabcityPage]
})
export class TabcityPageModule {}
