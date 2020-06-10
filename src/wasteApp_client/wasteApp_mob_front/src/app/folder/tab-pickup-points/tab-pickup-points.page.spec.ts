import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { TabPickupPointsPage } from './tab-pickup-points.page';

describe('TabPickupPointsPage', () => {
  let component: TabPickupPointsPage;
  let fixture: ComponentFixture<TabPickupPointsPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabPickupPointsPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(TabPickupPointsPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
