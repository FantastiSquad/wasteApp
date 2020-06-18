import { NgModule, ɵINJECTOR_IMPL__POST_R3__ } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TabsPage } from './tabs.page';
import { AuthGuard } from '../guards/auth.guard';
import { DataResolverService } from '../shared/services/data-resolver.service';

const routes: Routes = [
  {
    path: 'tabs',
    component: TabsPage,
    children: [
      {
        path: 'tab-home',
        loadChildren: () => import('../tab-home/tab-home.module').then(m => m.TabHomePageModule)
      },
      {
        path: 'tab-home/:role',
        resolve: {
          role: DataResolverService
        },
        loadChildren: () => import('../tab-home/tab-home.module').then(m => m.TabHomePageModule)
      },
      {
        path: 'tab-basket',
        loadChildren: () => import('../tab-basket/tab-basket.module').then(m => m.TabBasketPageModule),
        canActivate: [AuthGuard]
      },
      {
        path: 'tab-bin',
        loadChildren: () => import('../tab-bin/tab-bin.module').then(m => m.TabBinPageModule)
      },
      {
        path: 'tab-geoloc',
        loadChildren: () => import('../tab-geoloc/tab-geoloc.module').then(m => m.TabGeolocPageModule)
      },
      {
        path: '',
        redirectTo: '/tabs/tab-home/home',
        pathMatch: 'full'
      }
    ]
  },
  {
    path: '',
    redirectTo: '/tabs/tab-home/home',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TabsPageRoutingModule { }
