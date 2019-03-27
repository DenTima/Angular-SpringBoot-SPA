import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges, ViewChild} from "@angular/core";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";

@Component({
  selector: 'employees-table',
  templateUrl: './employees-table.component.html'
})

export class EmployeesTableComponent implements OnInit, OnChanges {
  @Input() employees = [];
  @Output() onDeleteEmployeeClick = new EventEmitter();
  @Output() onViewEmployeeClick = new EventEmitter();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  dataSource = new MatTableDataSource();
  displayedColumns: string[] = ['empID', 'empName', 'empActive', 'empDepartment', 'view', 'delete'];

  ngOnInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  ngOnChanges(changes: SimpleChanges) {
    this.dataSource.data = this.employees;
  }

  deleteEmployee(id: number) {
    this.onDeleteEmployeeClick.emit(id);
  }

  viewEmployee(id: number) {
    this.onViewEmployeeClick.emit(id);
  }
}
