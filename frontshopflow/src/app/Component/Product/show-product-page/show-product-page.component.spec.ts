import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowProductPageComponent } from './show-product-page.component';

describe('ShowProductPageComponent', () => {
  let component: ShowProductPageComponent;
  let fixture: ComponentFixture<ShowProductPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShowProductPageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShowProductPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
