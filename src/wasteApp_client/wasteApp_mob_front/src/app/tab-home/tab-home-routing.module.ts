import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TabHomePage } from './tab-home.page';

const routes: Routes = [
  {
    path: '',
    component: TabHomePage,
    children:[
      {
        path: 'home',
        loadChildren: () =>
        import('../pages/home/home.module').then(m => m.HomePageModule)
      },
      {
        path: 'login',
        loadChildren: () =>
        import('../pages/login/login.module').then(m => m.LoginPageModule)
      },
      {
        path: 'account',
        loadChildren: () =>
        import('../pages/account/account.module').then(m => m.AccountPageModule)
      },
      {
      path: 'register',
      loadChildren: () =>
      import('../pages/register/register.module').then(m => m.RegisterPageModule)
      },
      {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TabHomePageRoutingModule {}
