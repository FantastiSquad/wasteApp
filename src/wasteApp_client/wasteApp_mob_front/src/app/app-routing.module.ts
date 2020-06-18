import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [

  {
    path: '',
    redirectTo: 'map',
    pathMatch: 'full'
  },
  {
    path:'pickup',
    loadChildren: () => import('./pages/tab-pickup-points/tab-pickup-points.module').then( m => m.TabPickupPointsPageModule)
  },
  {
    path:'city',
    loadChildren: () => import('./pages/tabcity/tabcity.module').then( m => m.TabcityPageModule)
  },
  { path: '', 
  loadChildren: () => import('./welcome/welcome.module').then( m => m.WelcomePageModule)
  },
  // {
  //   path: 'register',
  //   loadChildren: () => import('./pages/register/register.module').then( m => m.RegisterPageModule)
  // },
  // {
  //   path: 'home',
  //   loadChildren: () => import('./pages/home/home.module').then( m => m.HomePageModule)
  // },
  // {
  //   path: 'account',
  //   loadChildren: () => import('./pages/account/account.module').then( m => m.AccountPageModule)
  // },
  // {
  //   path: 'login',
  //   loadChildren: () => import('./pages/login/login.module').then( m => m.LoginPageModule)
  // },
  {

    path: '',
    loadChildren: () => import('./tabs/tabs.module').then( m => m.TabsPageModule)
  },

  {
    path: 'map',
    loadChildren: () => import('./map/map.module').then( m => m.MapPageModule)
  }

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
