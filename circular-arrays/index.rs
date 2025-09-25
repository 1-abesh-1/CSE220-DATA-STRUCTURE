struct CircularArr {
    cap: usize,
    current: usize,
    arr: Box<[i32]>,
    front: usize,
    rear: usize,
}

impl CircularArr {
    fn new(size: usize) -> Self {
        Self {
            arr: vec![0; size].into_boxed_slice(),
            current: 0,
            front: 0,
            rear: 0,
            cap: size,
        }
    }

    fn push(&mut self, data: i32) {
        if self.current == self.cap {
            println!("memory full");
            return;
        }
        self.arr[self.rear] = data;
        self.rear = (self.rear + 1) % self.cap;
        self.current += 1;
    }

    fn pop(&mut self) {
        if self.empty() {
            println!("empty");
            return;
        }
        self.front = (self.front + 1) % self.cap;
        self.current -= 1;
    }

    fn empty(&self) -> bool {
        self.current == 0
    }

    fn front_view(&self) -> Option<i32> {
        if self.empty() {
            println!("empty");
            return None;
        }
        Some(self.arr[self.front])
    }

    fn print_all(&self) {
        for i in 0..self.cap {
            print!("{} ", self.arr[i]);
        }
        println!();
    }
}

fn main() {
    let mut abesh = CircularArr::new(5);

    abesh.push(1);
    abesh.push(2);
    abesh.push(3);
    abesh.push(4);
    abesh.push(5);
    abesh.push(6); // will print "memory full"

    println!("after pushing");
    abesh.print_all();

    abesh.pop();
    println!("after popping");
    abesh.print_all();

    abesh.push(8);
    println!("after pushing new");
    abesh.print_all();

    if let Some(val) = abesh.front_view() {
        println!("Front element: {}", val);
    }
}
