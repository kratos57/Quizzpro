import { TestBed } from '@angular/core/testing';
import { CanActivate } from '@angular/router';

import { secureInnerGuard } from './secure-inner.guard';

describe('secureInnerGuard', () => {
  let guard: CanActivate;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(secureInnerGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
