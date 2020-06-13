import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ResearchZoneFormPageRoutingModule } from './research-zone-form-routing.module';

import { ResearchZoneFormPage } from './research-zone-form.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ResearchZoneFormPageRoutingModule
  ],
  declarations: [ResearchZoneFormPage]
})
export class ResearchZoneFormPageModule {}
