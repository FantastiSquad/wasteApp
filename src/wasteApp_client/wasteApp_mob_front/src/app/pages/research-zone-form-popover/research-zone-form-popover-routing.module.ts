import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ResearchZoneFormPopoverComponent } from './research-zone-form-popover.component';

const routes: Routes = [
  {
    path: '',
    component: ResearchZoneFormPopoverComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ResearchZoneFormPopoverRoutingModule {}
