import java.util.ArrayList;

public class ArrayListG {
  
private int V; public int V() {return V;} // number of vertices
private int E; public int E() {return E;} // number of edges
private ArrayList<Integer>[] adj; // adjacency lists

public ArrayListG(In in) {
  V = in.readInt(); E = in.readInt(); 
  adj = (ArrayList<Integer>[]) new ArrayList[V];
  for (int v=0; v<V; v++) adj[v] = new ArrayList<Integer>();
  for (int e=0; e<E; e++) {
    int v = in.readInt();
    int w = in.readInt();
    addEdge(v,w);
    }
}

public void addEdge(Integer v, Integer w) {adj[v].add(0,w); adj[w].add(0,v);}

public String toString(){
  String s = "";
  for (int v=0; v<V; v++) s += (v + " : " + adj[v] + "\n");
  return s;
}

public void dfs(Integer v, boolean[] marked) {
  marked[v] = true;
  for (Integer w : adj[v]) if (! marked[w]) dfs(w,marked);
}

public void testdfs(){
  for(;;) { // infinite loop
  boolean[] marked = new boolean[V];
    StdOut.print("Enter node: "); Integer n = StdIn.readInt();
    if (n < 0) break;
    dfs(n,marked);
    for(int v=0;v<V;v++) StdOut.print(marked[v]?v+" ":". "); 
    StdOut.println();
  }  
}
  
public void pathdfs(Integer u, Integer v, Integer[] paths) {
  paths[v] = u;
  for (Integer w : adj[v]) if (paths[w]==null) pathdfs(v,w,paths);
}

public void testpathdfs(){
  for(;;) { // infinite loop
  Integer[] paths = new Integer[V];
    StdOut.print("Enter node: "); Integer n = StdIn.readInt();
    if (n < 0) break;
    pathdfs(n,n,paths);
    for(int v=0;v<V;v++) StdOut.print(paths[v]!=null?paths[v]+" ":". "); 
    StdOut.println();
    for(int v=0;v<V;v++) if (paths[v]!=null) {
      int i = v;
      while (i!=paths[i]) { StdOut.print(i+"-"); i = paths[i]; }
    StdOut.println(n);      }
  }  
}

public static void main(String[] args)  {
    ArrayListG g = new ArrayListG(new In(args[0]));
    StdOut.print(g.toString());
    g.testdfs();
    g.testpathdfs();
  
}//End of main
}//End of ArrayListG, based on Algorithms, 4th Edition, Sec. 4.1
