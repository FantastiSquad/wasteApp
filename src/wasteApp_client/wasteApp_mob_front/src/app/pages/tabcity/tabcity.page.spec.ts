import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { TabcityPage } from './tabcity.page';

describe('TabcityPage', () => {
  let component: TabcityPage;
  let fixture: ComponentFixture<TabcityPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabcityPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(TabcityPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
