import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ResearchZoneFormPage } from './research-zone-form.page';

describe('ResearchZoneFormPage', () => {
  let component: ResearchZoneFormPage;
  let fixture: ComponentFixture<ResearchZoneFormPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResearchZoneFormPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ResearchZoneFormPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
