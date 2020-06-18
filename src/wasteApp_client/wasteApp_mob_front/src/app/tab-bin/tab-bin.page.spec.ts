import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { TabBinPage } from './tab-bin.page';

describe('TabBinPage', () => {
  let component: TabBinPage;
  let fixture: ComponentFixture<TabBinPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabBinPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(TabBinPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
