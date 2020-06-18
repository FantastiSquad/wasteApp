import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TabBinPage } from './tab-bin.page';

const routes: Routes = [
  {
    path: '',
    component: TabBinPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TabBinPageRoutingModule {}
