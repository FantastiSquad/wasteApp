import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonicModule } from '@ionic/angular';

import { ResearchZoneFormPopoverComponent } from './research-zone-form-popover.component';
import { ResearchZoneFormPopoverRoutingModule } from './research-zone-form-popover-routing.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ResearchZoneFormPopoverRoutingModule
  ],
  declarations: [ResearchZoneFormPopoverComponent]
})
export class ResearchZoneFormPopoverModule {}
