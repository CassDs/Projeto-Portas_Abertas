import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { InputTextComponent } from './input-text/input-text.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

const COMPONENTS = [HeaderComponent, InputTextComponent];

@NgModule({
  declarations: [...COMPONENTS],
  imports: [CommonModule, FormsModule, ReactiveFormsModule, FormsModule],
  exports: [...COMPONENTS],
})
export class SharedModule {}
