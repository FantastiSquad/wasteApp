import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TabGeolocPage } from './tab-geoloc.page';

const routes: Routes = [
  {
    path: '',
    component: TabGeolocPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TabGeolocPageRoutingModule {}
