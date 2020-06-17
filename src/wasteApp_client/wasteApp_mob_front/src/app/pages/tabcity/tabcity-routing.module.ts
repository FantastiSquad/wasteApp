import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TabcityPage } from './tabcity.page';

const routes: Routes = [
  {
    path: '',
    component: TabcityPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TabcityPageRoutingModule {}
