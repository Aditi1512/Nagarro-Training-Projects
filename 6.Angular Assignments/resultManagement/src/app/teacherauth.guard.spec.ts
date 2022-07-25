import { TestBed } from '@angular/core/testing';

import { TeacherauthGuard } from './teacherauth.guard';

describe('TeacherauthGuard', () => {
  let guard: TeacherauthGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(TeacherauthGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
