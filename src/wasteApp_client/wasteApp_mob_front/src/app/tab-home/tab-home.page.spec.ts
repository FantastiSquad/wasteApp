import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { TabHomePage } from './tab-home.page';

describe('TabHomePage', () => {
  let component: TabHomePage;
  let fixture: ComponentFixture<TabHomePage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabHomePage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(TabHomePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
