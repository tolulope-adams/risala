import subprocess

def get_git_branches():
    # Get all branches, both local and remote
    result = subprocess.run(["git", "branch", "-r"], capture_output=True, text=True)
    branches = result.stdout.splitlines()
    branches = [branch.strip() for branch in branches if branch]
    branches.pop(0)
    return branches

def cherry_pick_commit(commit_hash, target_branches):
    for branch in target_branches:
        # Checkout the branch by name (avoiding detached HEAD state)
        subprocess.run(["git", "checkout", branch], check=True)
        print(f"Checked out to {branch}")

        # Cherry-pick the commit
        result = subprocess.run(["git", "cherry-pick", commit_hash], capture_output=True, text=True)
        if result.returncode != 0:
            print(f"Failed to cherry-pick on {branch}: {result.stderr}")
            # Handle conflicts or skip to the next branch if desired
        else:
            print(f"Cherry-picked commit {commit_hash} to {branch}")

        # Commit the changes (if cherry-pick was successful)
        subprocess.run(["git", "commit", "--allow-empty", "-m", f"Cherry-pick commit {commit_hash}"], check=True)

        # Push the changes to the remote branch
        result = subprocess.run(["git", "push", "origin", branch], capture_output=True, text=True)
        if result.returncode != 0:
            print(f"Failed to push branch {branch}: {result.stderr}")
        else:
            print(f"Successfully pushed changes to {branch}")

def main():
    # Get all branches
    branches = get_git_branches()
    print("Branches found:", branches)

    # Specify the commit hash to cherry-pick
    commit_hash = input("Enter the commit hash to cherry-pick: ")

    # Remove the current branch from the list, or branches you don't want to touch
    current_branch = subprocess.run(["git", "rev-parse", "--abbrev-ref", "HEAD"], capture_output=True, text=True).stdout.strip()
    target_branches = [branch for branch in branches if branch != current_branch]

    print("Cherry-picking to branches:", target_branches)

    # Perform the cherry-pick and push to each branch
    cherry_pick_commit(commit_hash, target_branches)

    # Switch back to the original branch
    subprocess.run(["git", "checkout", current_branch], check=True)
    print(f"Switched back to {current_branch}")

if __name__ == "__main__":
    main()
