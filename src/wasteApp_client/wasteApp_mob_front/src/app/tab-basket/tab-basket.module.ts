import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { TabBasketPageRoutingModule } from './tab-basket-routing.module';

import { TabBasketPage } from './tab-basket.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    TabBasketPageRoutingModule
  ],
  declarations: [TabBasketPage]
})
export class TabBasketPageModule {}
