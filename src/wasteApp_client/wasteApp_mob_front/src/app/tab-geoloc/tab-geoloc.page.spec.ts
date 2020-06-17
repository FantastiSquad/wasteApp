import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { TabGeolocPage } from './tab-geoloc.page';

describe('TabGeolocPage', () => {
  let component: TabGeolocPage;
  let fixture: ComponentFixture<TabGeolocPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabGeolocPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(TabGeolocPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
