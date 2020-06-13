import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ResearchZoneFormPopoverComponent } from './research-zone-form-popover.component';

describe('ResearchZoneFormPopoverComponent', () => {
  let component: ResearchZoneFormPopoverComponent;
  let fixture: ComponentFixture<ResearchZoneFormPopoverComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResearchZoneFormPopoverComponent ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ResearchZoneFormPopoverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
