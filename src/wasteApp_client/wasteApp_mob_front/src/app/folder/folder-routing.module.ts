import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { FolderPage } from './folder.page';

const routes: Routes = [
  {
    path: '',
    component: FolderPage
  },{
    path: 'tabcity',
    loadChildren: () => import('./tabcity/tabcity.module').then( m => m.TabcityPageModule)
  },
  {
    path: 'tab-pickup-points',
    loadChildren: () => import('./tab-pickup-points/tab-pickup-points.module').then( m => m.TabPickupPointsPageModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class FolderPageRoutingModule {}
