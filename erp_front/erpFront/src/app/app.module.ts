import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatDialogModule} from "@angular/material/dialog";
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';

import { MachinePageComponent } from './components/machine-page/machine-page.component';
import { ProcessPageComponent } from './components/process-page/process-page.component';
import { LotPageComponent } from './components/lot-page/lot-page.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { MachineDialogComponent } from './components/machine-dialog/machine-dialog.component';
import { ProcessDialogComponent } from './components/process-dialog/process-dialog.component';
import { LotDialogComponent } from './components/lot-dialog/lot-dialog.component';


import { RouterModule } from '@angular/router';
import {MatButtonModule} from "@angular/material/button";
import {MatSelectModule} from "@angular/material/select";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule} from '@angular/material/sort';






@NgModule({
  declarations: [
    AppComponent,
    MachinePageComponent,
    ProcessPageComponent,
    LotPageComponent,
    PageNotFoundComponent,
    MachineDialogComponent,
    ProcessDialogComponent,
    LotDialogComponent

  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {path: 'machine-page', component: MachinePageComponent},
      {path: 'process-page', component: ProcessPageComponent},
      {path: 'lot-page', component: LotPageComponent},
      {path: '', redirectTo: '/machine-page', pathMatch: 'full'},
      {path: '**', component: PageNotFoundComponent}
    ]),
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
