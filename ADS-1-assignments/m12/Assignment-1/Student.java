class Student {
	String name;
	String dob;
	int s1;
	int s2;
	int s3;
	int total;
	String category;
	Student(String name, String dob, String s1, String s2, String s3, String total, String category) {
		this.name = name;
		this.dob = dob;
		this.s1 = Integer.parseInt(s1);
		this.s2 = Integer.parseInt(s2);
		this.s3 = Integer.parseInt(s3);
		this.total = Integer.parseInt(total);
		this.category = category;
	}
	public String getName() {
        return name;
	}
	public int getTotal() {
		return total;
	}
	public String getCategory() {
        return category;
	}
	public String getdob() {
		return dob;
	}
	public int compareTo(Student s) {
		if (this.total > s.total) {
			return 1;
		}
		if (this.total < s.total) {
			return -1;
		}
		if (this.s3 > s.s3) {
			return 1;
		}
		if (this.s3 < s.s3) {
			return -1;
		}
		if (this.s2 > s.s2) {
			return 1;
		}
		if (this.s2 < s.s2) {
			return -1;
		}
		// if (this.dob < s.dob) {
		// 	return 1;
		// }
		// if (this.dob > s.dob) {
  //           return -1;
		// }
		return 0;
	}
	public String toString() {
		return this.name+","+this.total+","+this.category;
	}
}