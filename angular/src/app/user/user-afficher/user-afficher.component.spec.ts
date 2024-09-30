import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserAfficherComponent } from './user-afficher.component';

describe('UserAfficherComponent', () => {
  let component: UserAfficherComponent;
  let fixture: ComponentFixture<UserAfficherComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserAfficherComponent]
    });
    fixture = TestBed.createComponent(UserAfficherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
