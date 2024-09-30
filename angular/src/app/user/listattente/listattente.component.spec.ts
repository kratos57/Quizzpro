import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListattenteComponent } from './listattente.component';

describe('ListattenteComponent', () => {
  let component: ListattenteComponent;
  let fixture: ComponentFixture<ListattenteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListattenteComponent]
    });
    fixture = TestBed.createComponent(ListattenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
