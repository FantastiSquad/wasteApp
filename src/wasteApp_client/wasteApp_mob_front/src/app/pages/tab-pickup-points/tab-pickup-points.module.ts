import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { TabPickupPointsPageRoutingModule } from './tab-pickup-points-routing.module';

import { TabPickupPointsPage } from './tab-pickup-points.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    TabPickupPointsPageRoutingModule
  ],
  declarations: [TabPickupPointsPage]
})
export class TabPickupPointsPageModule {}
