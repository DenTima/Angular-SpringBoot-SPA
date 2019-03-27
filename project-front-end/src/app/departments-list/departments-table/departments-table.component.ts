import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges, ViewChild} from "@angular/core";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";

@Component({
  selector: 'departments-table',
  templateUrl: './departments-table.component.html'
})

export class DepartmentsTableComponent implements OnInit, OnChanges {
  @Input() departments = [];
  @Output() onDeleteDepartmentClick = new EventEmitter();
  @Output() onViewDepartmentClick = new EventEmitter();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  dataSource = new MatTableDataSource();
  displayedColumns: string[] = ['depID', 'depName'];

  ngOnInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  ngOnChanges(changes: SimpleChanges) {
    this.dataSource.data = this.departments;
  }

  deleteDepartment(id: number) {
    this.onDeleteDepartmentClick.emit(id);
  }

  viewDepartment(id: number) {
    this.onViewDepartmentClick.emit(id);
  }
}
