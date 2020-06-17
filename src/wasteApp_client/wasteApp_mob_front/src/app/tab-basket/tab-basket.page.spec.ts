import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { TabBasketPage } from './tab-basket.page';

describe('TabBasketPage', () => {
  let component: TabBasketPage;
  let fixture: ComponentFixture<TabBasketPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabBasketPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(TabBasketPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
