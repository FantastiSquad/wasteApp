import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { ApiHelperService } from './shared/services/api-helper.service';
import { HttpClientModule } from '@angular/common/http';
import { IonicStorageModule } from '@ionic/storage';
import { SharedDirectivesModule } from './directives/shared-directives.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ResearchZoneFormPopoverModule } from './pages/research-zone-form-popover/research-zone-form-popover.module';


@NgModule({
  declarations: [AppComponent],
  entryComponents: [],
  imports: [
    BrowserModule,
    IonicModule.forRoot(),
    IonicStorageModule.forRoot(),
    AppRoutingModule,
    HttpClientModule,
    SharedDirectivesModule,
    FormsModule,
    ReactiveFormsModule,
    ResearchZoneFormPopoverModule,
  ],
  providers: [
    StatusBar,
    SplashScreen,
    { provide: RouteReuseStrategy, useClass: IonicRouteStrategy },
    ApiHelperService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
