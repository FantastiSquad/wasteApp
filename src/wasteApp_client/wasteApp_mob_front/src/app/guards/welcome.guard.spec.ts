import { TestBed } from '@angular/core/testing';

import { WelcomeGuard } from './welcome.guard';

describe('WelcomeGuard', () => {
  let guard: WelcomeGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(WelcomeGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
