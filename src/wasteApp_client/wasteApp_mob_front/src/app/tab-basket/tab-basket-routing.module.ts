import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TabBasketPage } from './tab-basket.page';

const routes: Routes = [
  {
    path: '',
    component: TabBasketPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TabBasketPageRoutingModule {}
