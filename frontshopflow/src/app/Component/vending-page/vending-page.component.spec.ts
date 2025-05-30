import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VendingPageComponent } from './vending-page.component';

describe('VendingPageComponent', () => {
  let component: VendingPageComponent;
  let fixture: ComponentFixture<VendingPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VendingPageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VendingPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
