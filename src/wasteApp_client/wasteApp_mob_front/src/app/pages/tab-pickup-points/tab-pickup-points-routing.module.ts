import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TabPickupPointsPage } from './tab-pickup-points.page';

const routes: Routes = [
  {
    path: '',
    component: TabPickupPointsPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TabPickupPointsPageRoutingModule {}
