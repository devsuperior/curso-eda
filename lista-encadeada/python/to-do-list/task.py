class TaskStatus:
    PENDING = "Pending"
    COMPLETED = "Completed"

class Task:
    def __init__(self, id, description, tag, status=TaskStatus.PENDING):
        self.id = id
        self.description = description
        self.tag = tag
        self.status = status

    def get_id(self):
        return self.id

    def get_description(self):
        return self.description

    def set_description(self, description):
        self.description = description

    def get_tag(self):
        return self.tag

    def set_tag(self, tag):
        self.tag = tag

    def get_status(self):
        return self.status

    def set_status(self, status):
        self.status = status

    def __str__(self):
        return f"Task {self.id}: {self.description} | Tag: {self.tag} | Status: {self.status}"

# Example:
# task = Task(id=1, description="Example Task", tag="Work")
# print(task)
