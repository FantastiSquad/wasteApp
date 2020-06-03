import { TestBed } from '@angular/core/testing';

import { GroupmentService } from './groupment.service';

describe('GroupmentService', () => {
  let service: GroupmentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GroupmentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
