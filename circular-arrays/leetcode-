class Solution {
public:
    bool circularArrayLoop(vector<int>& nums) {
        int n = nums.size();
        
        for (int i = 0; i < n; i++) {
            // Skip if already visited
            if (nums[i] == 0) continue;
            
            // Use slow and fast pointers (Floyd's cycle detection)
            int slow = i, fast = i;
            bool direction = nums[i] > 0; // true for forward, false for backward
            
            // Move pointers until we find a cycle or hit an invalid state
            do {
                // Move slow pointer one step
                slow = getNext(nums, slow, direction);
                if (slow == -1) break;
                
                // Move fast pointer two steps
                fast = getNext(nums, fast, direction);
                if (fast == -1) break;
                fast = getNext(nums, fast, direction);
                if (fast == -1) break;
                
            } while (slow != fast);
            
            // If we found a cycle (slow == fast and both are valid)
            if (slow != -1 && slow == fast) {
                return true;
            }
            
            // Mark all positions in this path as visited (set to 0)
            int curr = i;
            while (nums[curr] != 0 && ((nums[curr] > 0) == direction)) {
                int next = getNext(nums, curr, direction);
                nums[curr] = 0;
                curr = next;
                if (curr == -1) break;
            }
        }
        
        return false;
    }
    
private:
    int getNext(vector<int>& nums, int curr, bool direction) {
        // Check if current direction matches expected direction
        if ((nums[curr] > 0) != direction) return -1;
        
        int n = nums.size();
        int next = ((curr + nums[curr]) % n + n) % n;
        
        // Check for self-loop (single element cycle)
        if (next == curr) return -1;
        
        return next;
    }
};

// Alternative cleaner approach without modifying the input array
class SolutionAlternative {
public:
    bool circularArrayLoop(vector<int>& nums) {
        int n = nums.size();
        vector<bool> visited(n, false);
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            if (hasLoop(nums, i, visited)) {
                return true;
            }
        }
        
        return false;
    }
    
private:
    bool hasLoop(vector<int>& nums, int start, vector<bool>& visited) {
        int n = nums.size();
        bool direction = nums[start] > 0;
        unordered_set<int> currentPath;
        int curr = start;
        
        while (true) {
            // If we've seen this position in current path, we found a cycle
            if (currentPath.count(curr)) {
                return true;
            }
            
            // If already visited from previous starting point, no new cycle
            if (visited[curr]) {
                break;
            }
            
            // Check direction consistency
            if ((nums[curr] > 0) != direction) {
                break;
            }
            
            currentPath.insert(curr);
            int next = ((curr + nums[curr]) % n + n) % n;
            
            // Check for self-loop (invalid)
            if (next == curr) {
                break;
            }
            
            curr = next;
        }
        
        // Mark all positions in this path as visited
        for (int pos : currentPath) {
            visited[pos] = true;
        }
        
        return false;
    }
};
