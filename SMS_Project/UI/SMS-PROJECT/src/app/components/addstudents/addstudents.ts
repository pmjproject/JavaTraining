export class Addstudents {
    id: number;
    firstName: string;
    lastName: string;
    email: string;
    age: number;
    dob: string;
    courseId: number;
    active: boolean;
    city: string;
    address: string;
    number: string;

    constructor(
        id: number,
        firstName: string,
        lastName: string,
        email: string,
        age: number,
        dob: string,
        courseId: number,
        active: boolean,
        number: string,
        address: string,
        city: string

        ){
            this.id=id;
            this.firstName=firstName;
            this.lastName=lastName;
            this.email=email;
            this.age=age;
            this.dob=dob;
            this.courseId=courseId;
            this.active=active;
            this.number=number;
            this.address=address;
            this.city=city;

        }

}
