import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowSalePageComponent } from './show-sale-page.component';

describe('ShowSalePageComponent', () => {
  let component: ShowSalePageComponent;
  let fixture: ComponentFixture<ShowSalePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShowSalePageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShowSalePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
