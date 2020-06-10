import { TestBed } from '@angular/core/testing';

import { PickupPointService } from './pickup-point.service';

describe('PickupPointService', () => {
  let service: PickupPointService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PickupPointService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
