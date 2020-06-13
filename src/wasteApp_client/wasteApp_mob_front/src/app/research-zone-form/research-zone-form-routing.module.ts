import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ResearchZoneFormPage } from './research-zone-form.page';

const routes: Routes = [
  {
    path: '',
    component: ResearchZoneFormPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ResearchZoneFormPageRoutingModule {}
