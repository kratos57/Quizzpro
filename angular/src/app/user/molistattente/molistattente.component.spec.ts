import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MolistattenteComponent } from './molistattente.component';

describe('MolistattenteComponent', () => {
  let component: MolistattenteComponent;
  let fixture: ComponentFixture<MolistattenteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MolistattenteComponent]
    });
    fixture = TestBed.createComponent(MolistattenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
