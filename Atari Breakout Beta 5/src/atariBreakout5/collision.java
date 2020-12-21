package atariBreakout5;
  


class collision {
	
	static boolean left = false;
	static boolean right = false;
	boolean top = false;
	boolean bottom = false;
	
	public void detect(wall w, ball b) {
		if (w.side.equalsIgnoreCase("L")) {
			if (b.lx <= w.x1 || b.lx <= w.x2) {
				b.xvel = -b.xvel;
				b.xtl = b.xtl + b.xvel;
				left = true;
			}else {
				left = false;
			}
		}else if (w.side.equalsIgnoreCase("R")) {
			if ((b.rx >= w.x1) || (b.rx >= w.x2)) {
				b.xvel = -b.xvel;
				b.xtl = b.xtl + b.xvel;
				right = true;
			}else {
				right = false;
			}
		}else if (w.side.equalsIgnoreCase("T")) {
			if ((b.ty <= w.y1) || (b.ty <= w.y2)) {
				b.yvel = -b.yvel;
				b.ytl = b.ytl + b.yvel;
				top = true;
				w.top = true;
			}else {
				w.top = false;
				top = false;
			}
		}else if (w.side.equalsIgnoreCase("B")) {
			if ((b.by >= w.y1) || (b.by >= w.y2)) {
				b.yvel = -b.yvel;
				b.ytl = b.ytl + b.yvel;
				w.bottom = true;
				bottom = true;
			}else {
				bottom = false;
				w.bottom = false;
			}
		}
	}
	//specificly collisions for the wall and the paddle (essentially just stops the paddle)
	public void detect(wall w, paddle p, int WallorBall) {
		if (w.side.equalsIgnoreCase("L")) {
			if ((p.xtl <= w.x1) || (p.xbl <= w.x2)) {
				left = true;
			}else
				left = false;
		}else if (w.side.equalsIgnoreCase("R")) {
			if ((p.xtr >= w.x1) || (p.xbr >= w.x2)) {
				right = true;
			}else
				right = false;
		}
	}
	
	//specificly collisions for the ball and the paddle
	public void detect(ball b, paddle p) {
			if (b.ry > p.ytl && b.ry < p.ybl) {
				if (b.rx > p.xtl && b.rx < p.xtr) {
					b.xvel = -b.xvel;
					b.xtl -= b.xvel;
				}else if (b.lx < p.xtr && b.lx > p.xtl) {
					b.xvel = -b.xvel;
					b.xtl += b.xvel;
					b.xtl += b.xvel;
				}
			}else if (b.by > p.ytr && b.by < p.ybr) {
				if (b.bx > p.xtl && b.bx <p.xtr) {
					b.yvel = -b.yvel;
					b.ytl += b.yvel;
				}
			}else if (b.ty < p.ybr && b.ty > p.ytr) {
				if (b.bx > p.xtl && b.bx <p.xtr) {
					b.yvel = -b.yvel;
					b.ytl += b.yvel;
				}
			}
		}
	
	public void detect(ball b, brick p) {
		if (b.ry > p.ytl && b.ry < p.ybl) {
			if (b.rx > p.xtl && b.rx < p.xtr) {
				b.xvel = -b.xvel;
				b.xtl -= b.xvel;
				p.hit = true;
			}else if (b.lx < p.xtr && b.lx > p.xtl) {
				b.xvel = -b.xvel;
				b.xtl += b.xvel;
				b.xtl += b.xvel;
				p.hit = true;
			}
		}else if (b.by > p.ytr && b.by < p.ybr) {
			if (b.bx > p.xtl && b.bx <p.xtr) {
				b.yvel = -b.yvel;
				b.ytl += b.yvel;
				p.hit = true;
			}
		}else if (b.ty < p.ybr && b.ty > p.ytr) {
			if (b.bx > p.xtl && b.bx <p.xtr) {
				b.yvel = -b.yvel;
				b.ytl += b.yvel;
				p.hit = true;
			}
		}else {
			p.hit = false;
		}
	}
}
