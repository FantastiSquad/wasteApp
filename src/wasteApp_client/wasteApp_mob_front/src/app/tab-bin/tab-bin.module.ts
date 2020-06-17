import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { TabBinPageRoutingModule } from './tab-bin-routing.module';

import { TabBinPage } from './tab-bin.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    TabBinPageRoutingModule
  ],
  declarations: [TabBinPage]
})
export class TabBinPageModule {}
